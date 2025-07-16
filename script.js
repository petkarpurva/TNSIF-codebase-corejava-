// script.js
class DiceDuel {
   constructor() {
     this.diceFaces = ['⚀', '⚁', '⚂', '⚃', '⚄', '⚅'];
     this.scores = { player1: 0, player2: 0 };
     this.round = 1;
     this.isRolling = false;
     
     this.dice1 = document.getElementById('dice1');
     this.dice2 = document.getElementById('dice2');
     this.result = document.getElementById('result');
     this.score1 = document.getElementById('score1');
     this.score2 = document.getElementById('score2');
     this.roundCounter = document.getElementById('round');
     
     this.initializeAudio();
   }
   
   initializeAudio() {
     // Create audio context for sound effects
     this.audioContext = new (window.AudioContext || window.webkitAudioContext)();
     this.sounds = {
       roll: this.createBeep(400, 0.1),
       win: this.createBeep(600, 0.3),
       tie: this.createBeep(300, 0.2)
     };
   }
   
   createBeep(frequency, duration) {
     return () => {
       const oscillator = this.audioContext.createOscillator();
       const gainNode = this.audioContext.createGain();
       
       oscillator.connect(gainNode);
       gainNode.connect(this.audioContext.destination);
       
       oscillator.frequency.value = frequency;
       oscillator.type = 'sine';
       
       gainNode.gain.setValueAtTime(0.3, this.audioContext.currentTime);
       gainNode.gain.exponentialRampToValueAtTime(0.01, this.audioContext.currentTime + duration);
       
       oscillator.start(this.audioContext.currentTime);
       oscillator.stop(this.audioContext.currentTime + duration);
     };
   }
   
   async rollDice() {
     if (this.isRolling) return;
     
     this.isRolling = true;
     this.result.textContent = '';
     this.result.className = 'result';
     
     // Play roll sound
     try {
       this.sounds.roll();
     } catch (e) {
       console.log('Audio not available');
     }
     
     // Add rolling animation
     this.dice1.classList.add('rolling');
     this.dice2.classList.add('rolling');
     
     // Animate dice rolling with multiple face changes
     await this.animateRolling();
     
     // Get final results
     const roll1 = Math.floor(Math.random() * 6);
     const roll2 = Math.floor(Math.random() * 6);
     
     // Set final dice faces
     this.dice1.querySelector('.dice-face').textContent = this.diceFaces[roll1];
     this.dice2.querySelector('.dice-face').textContent = this.diceFaces[roll2];
     
     // Remove rolling animation
     this.dice1.classList.remove('rolling');
     this.dice2.classList.remove('rolling');
     
     // Determine winner and update scores
     this.determineWinner(roll1, roll2);
     
     // Update display
     this.updateDisplay();
     
     this.isRolling = false;
   }
   
   async animateRolling() {
     const duration = 1000; // 1 second
     const interval = 100; // Change face every 100ms
     const steps = duration / interval;
     
     for (let i = 0; i < steps; i++) {
       await new Promise(resolve => setTimeout(resolve, interval));
       
       // Change dice faces randomly during animation
       const randomFace1 = this.diceFaces[Math.floor(Math.random() * 6)];
       const randomFace2 = this.diceFaces[Math.floor(Math.random() * 6)];
       
       this.dice1.querySelector('.dice-face').textContent = randomFace1;
       this.dice2.querySelector('.dice-face').textContent = randomFace2;
     }
   }
   
   determineWinner(roll1, roll2) {
     const value1 = roll1 + 1;
     const value2 = roll2 + 1;
     
     if (value1 > value2) {
       this.scores.player1++;
       this.result.textContent = '🏆 PLAYER 1 WINS!';
       this.result.style.color = '#ff6b6b';
       this.result.style.textShadow = '0 0 20px rgba(255, 107, 107, 0.8)';
       this.createWinnerEffect('#ff6b6b');
       try {
         this.sounds.win();
       } catch (e) {
         console.log('Audio not available');
       }
     } else if (value1 < value2) {
       this.scores.player2++;
       this.result.textContent = '🏆 PLAYER 2 WINS!';
       this.result.style.color = '#4ecdc4';
       this.result.style.textShadow = '0 0 20px rgba(78, 205, 196, 0.8)';
       this.createWinnerEffect('#4ecdc4');
       try {
         this.sounds.win();
       } catch (e) {
         console.log('Audio not available');
       }
     } else {
       this.result.textContent = '🤝 TIE GAME!';
       this.result.style.color = '#f7b731';
       this.result.style.textShadow = '0 0 20px rgba(247, 183, 49, 0.8)';
       try {
         this.sounds.tie();
       } catch (e) {
         console.log('Audio not available');
       }
     }
     
     this.result.classList.add('winner');
     this.round++;
   }
   
   createWinnerEffect(color) {
     const winnerEffect = document.createElement('div');
     winnerEffect.className = 'winner-effect';
     document.body.appendChild(winnerEffect);
     
     // Create confetti
     for (let i = 0; i < 50; i++) {
       const confetti = document.createElement('div');
       confetti.className = 'confetti';
       confetti.style.left = Math.random() * 100 + '%';
       confetti.style.backgroundColor = color;
       confetti.style.animationDelay = Math.random() * 2 + 's';
       confetti.style.animationDuration = (Math.random() * 2 + 2) + 's';
       winnerEffect.appendChild(confetti);
     }
     
     // Remove effect after animation
     setTimeout(() => {
       document.body.removeChild(winnerEffect);
     }, 4000);
   }
   
   updateDisplay() {
     this.score1.textContent = this.scores.player1;
     this.score2.textContent = this.scores.player2;
     this.roundCounter.textContent = this.round;
     
     // Add pulse animation to updated scores
     this.score1.style.animation = 'none';
     this.score2.style.animation = 'none';
     
     setTimeout(() => {
       this.score1.style.animation = 'winnerPulse 0.5s ease-in-out';
       this.score2.style.animation = 'winnerPulse 0.5s ease-in-out';
     }, 10);
   }
   
   resetGame() {
     this.scores = { player1: 0, player2: 0 };
     this.round = 1;
     this.isRolling = false;
     
     // Reset display
     this.dice1.querySelector('.dice-face').textContent = '⚀';
     this.dice2.querySelector('.dice-face').textContent = '⚀';
     this.result.textContent = '';
     this.result.className = 'result';
     this.result.style.color = '#fff';
     this.result.style.textShadow = '0 0 20px rgba(255, 255, 255, 0.8)';
     
     this.updateDisplay();
     
     // Add reset animation
     this.dice1.style.animation = 'diceRoll 0.5s ease-in-out';
     this.dice2.style.animation = 'diceRoll 0.5s ease-in-out';
     
     setTimeout(() => {
       this.dice1.style.animation = '';
       this.dice2.style.animation = '';
     }, 500);
   }
 }
 
 // Initialize the game
 const game = new DiceDuel();
 
 // Global functions for HTML onclick events
 function rollDice() {
   game.rollDice();
 }
 
 function resetGame() {
   game.resetGame();
 }
 
 // Add keyboard support
 document.addEventListener('keydown', (event) => {
   if (event.code === 'Space') {
     event.preventDefault();
     rollDice();
   } else if (event.code === 'KeyR') {
     resetGame();
   }
 });
 
 // Add some extra interactive effects
 document.addEventListener('DOMContentLoaded', () => {
   // Add hover effects to dice
   const dice = document.querySelectorAll('.dice');
   dice.forEach(die => {
     die.addEventListener('mouseenter', () => {
       if (!game.isRolling) {
         die.style.transform = 'scale(1.1) rotateY(15deg)';
       }
     });
     
     die.addEventListener('mouseleave', () => {
       if (!game.isRolling) {
         die.style.transform = 'scale(1) rotateY(0deg)';
       }
     });
   });
   
   // Add particle effect on page load
   setTimeout(() => {
     const colors = ['#ff6b6b', '#4ecdc4', '#45b7d1', '#f7b731'];
     for (let i = 0; i < 20; i++) {
       const particle = document.createElement('div');
       particle.className = 'confetti';
       particle.style.position = 'fixed';
       particle.style.left = Math.random() * 100 + '%';
       particle.style.top = '-10px';
       particle.style.backgroundColor = colors[Math.floor(Math.random() * colors.length)];
       particle.style.animation = `confettiFall ${Math.random() * 2 + 2}s ease-in-out forwards`;
       particle.style.animationDelay = Math.random() * 2 + 's';
       document.body.appendChild(particle);
       
       setTimeout(() => {
         if (document.body.contains(particle)) {
           document.body.removeChild(particle);
         }
       }, 4000);
     }
   }, 500);
 });
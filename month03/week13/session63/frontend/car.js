const cube = document.querySelector('.cube');
let mouseX = 0;
let mouseY = 0;

document.addEventListener('mousemove', (e) => {
  // Normalize mouse position to rotate the cube
  mouseX = (e.clientX / window.innerWidth - 0.5) * 360;
  mouseY = (e.clientY / window.innerHeight - 0.5) * -360;

  cube.style.transform = `rotateX(${mouseY}deg) rotateY(${mouseX}deg)`;
});
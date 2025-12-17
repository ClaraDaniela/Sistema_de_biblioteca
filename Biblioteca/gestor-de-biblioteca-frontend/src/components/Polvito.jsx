import '../styles/Polvito.css';

function Polvito() {
  const particles = Array.from({ length: 40 }, (_, i) => ({
    id: i,
    size: 2 + Math.random() * 4,
    color: ['#ffd700', '#ffed4e', '#fff5ba', '#d4af37'][Math.floor(Math.random() * 4)]
  }));

  return (
    <div className="magic-dust-container">
      {particles.map((particle) => (
        <div
          key={particle.id}
          className="dust-particle"
          style={{
            left: `${Math.random() * 100}%`,
            width: `${particle.size}px`,
            height: `${particle.size}px`,
            background: `radial-gradient(circle, ${particle.color}, transparent)`,
            animationDelay: `${Math.random() * 5}s`,
            animationDuration: `${4 + Math.random() * 6}s`
          }}
        />
      ))}
    </div>
  );
}

export default Polvito;
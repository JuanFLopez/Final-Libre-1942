package Visitors;

import Entidades.Entidad;
import Entidades.EnemigoGlass;
import Entidades.EnemigoBase;
import Entidades.Jugador;
import Entidades.ProyectilEnemigo;
import Entidades.ProyectilNormal;
import Entidades.SuperProyectil;
import Entidades.Powerups.Inmunidad;
import Entidades.Powerups.SuperArma;
import Entidades.Powerups.SuperVelocidad;

public abstract class Visitor {
	protected Entidad entidad;

	public Visitor(Entidad entidad) {
		this.entidad = entidad;
	}

	public void visit(EnemigoGlass enemigo) {
	}

	public void visit(Jugador jugador) {
	}

	public void visit(EnemigoBase enemigo) {
	}

	public void visit(SuperArma powerup) {
	}

	
	public void visit(SuperVelocidad premio) {
	}

	public void visit(Inmunidad premio) {
	}

	public void visit(ProyectilEnemigo disparo) {
	}

	public void visit(SuperProyectil proyectil) {
	}

	public void visit(ProyectilNormal proyectil) {
	}

}

package Movimientos;

import Entidades.Entidad;

import Entidades.ProyectilEnemigo;
import EntidadesGraficas.Entidad_grafica;

public class VerticalRemoveRango extends Vertical {

	protected int posicionMaxima;
	
	public VerticalRemoveRango(Entidad entidad, int direccion) {
		super(entidad, direccion);
		ProyectilEnemigo p= (ProyectilEnemigo)entidad;
		posicionMaxima=entidad.getGrafico().getY()+p.getRango();
	}
	
	@Override
	public void mover() {
		Entidad_grafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();
		
		if ( siguientePosY > limiteY ||(this.direccion==ABAJO &&siguientePosY > posicionMaxima)) {
			entidad.eliminar();
		}else 
			if (siguientePosY < 0 || (this.direccion==ARRIBA && siguientePosY<posicionMaxima)) {
				entidad.eliminar();
			}else
				g.setLocation(g.getX(), siguientePosY);
		
	}

}

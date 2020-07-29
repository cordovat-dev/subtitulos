package sub2;

public class RangoTiempo {
	protected long desde;
	protected long hasta;
	
	public RangoTiempo(long desde_, long hasta_){
		desde = desde_;
		hasta = hasta_;
	}

	public long getDesde() {
		return desde;
	}

	public long getHasta() {
		return hasta;
	}
}

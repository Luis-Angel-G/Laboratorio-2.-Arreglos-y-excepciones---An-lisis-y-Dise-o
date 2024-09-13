public class Secciones {
	private int[][] vip = new int[5][10];
	private int[][] platino = new int[8][12];
	private int[][] oro = new int[10][15];
	private int[][] plata = new int[12][20];
	
	public Secciones() {
		
	}
	
	public Secciones(int[][] vip, int[][] platino, int[][] oro, int[][] plata) {
		this.vip = vip;
		this.platino = platino;
		this.oro = oro;
		this.plata = plata;
	}
}
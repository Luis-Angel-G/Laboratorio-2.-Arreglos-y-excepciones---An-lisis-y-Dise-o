public class Secciones {
    private int[][] vip = new int[5][10];
    private int[][] platino = new int[8][12];
    private int[][] oro = new int[10][15];
    private int[][] plata = new int[12][20];

    public Secciones() {
        inicializarSecciones();
    }

    private void inicializarSecciones() {
        for (int i = 0; i < vip.length; i++)
            for (int j = 0; j < vip[i].length; j++)
                vip[i][j] = 1;

        for (int i = 0; i < platino.length; i++)
            for (int j = 0; j < platino[i].length; j++)
                platino[i][j] = 1;

        for (int i = 0; i < oro.length; i++)
            for (int j = 0; j < oro[i].length; j++)
                oro[i][j] = 1;

        for (int i = 0; i < plata.length; i++)
            for (int j = 0; j < plata[i].length; j++)
                plata[i][j] = 1;
    }

    public int[][] getVip() {
		return vip;
	}
    public int[][] getPlatino() {
		return platino;
	}
    public int[][] getOro() {
		return oro;
	}
    public int[][] getPlata() {
		return plata;
	}
}
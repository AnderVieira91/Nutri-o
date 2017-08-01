package edu.fatec.sjc.grafico;

public class Menino {

	private double[] perimetroCefalicoMinimo = { 31.9, 34.9, 36.8, 38.1, 39.2, 40.1, 40.9, 41.5, 42, 42.5, 42.9, 43.2,
			43.5, 43.8, 44, 44.2, 44.4, 44.6, 44.7, 44.9, 45, 45.2, 45.3, 45.4, 45.5 };
	private double[] perimetroCefalicoMaximo = { 37, 39.6, 41.5, 42.9, 44, 45, 45.8, 46.4, 47, 47.5, 47.9, 48.3, 48.6,
			48.9, 49.2, 49.4, 49.6, 49.8, 50, 50.2, 50.4, 50.5, 50.7, 50.8, 51 };

	private double[] pesoMinimo0a2Anos = { 2.5, 3.4, 4.3, 5.0, 5.6, 6.0, 6.4, 6.7, 6.9, 7.1, 7.4, 7.6, 7.7, 7.9, 8.1, 8.3,
			8.4, 8.6, 8.8, 8.9, 9.1, 9.2, 9.4, 9.5, 9.7 };
	private double[] pesoMaximo0a2Anos = { 4.4, 5.8, 7.1, 8.0, 8.7, 9.3, 9.8, 10.3, 10.7, 11.0, 11.4, 11.7, 12.0, 12.3,
			12.6, 12.8, 13.1, 13.4, 13.7, 13.9, 14.2, 14.5, 14.7, 15.0, 15.3 };

	private double[] pesoMinimo2a5Anos = { 9.7, 9.8, 10.0, 10.1, 10.2, 10.4, 10.5, 10.7, 10.8, 10.9, 11.0, 11.2, 11.3,
			11.4, 11.5, 11.6, 11.8, 11.9, 12.0, 12.1, 12.2, 12.4, 12.5, 12.6, 12.7, 12.8, 12.9, 13.1, 13.2, 13.3, 13.4,
			13.5, 13.6, 13.7, 13.8, 14.0, 14.1 };
	private double[] pesoMaximo2a5Anos = { 15.3, 15.5, 15.8, 16.1, 16.3, 16.6, 16.9, 17.1, 17.4, 17.6, 17.8, 18.1, 18.3,
			18.6, 18.8, 19.0, 19.3, 19.5, 19.7, 20.0, 20.2, 20.5, 20.7, 20.9, 21.2, 21.4, 21.7, 21.9, 22.2, 22.4, 22.7,
			22.9, 23.2, 23.4, 23.7, 23.9, 24.2 };

	private double[] alturaMinima2a5Anos = { 81.7, 81.7, 82.5, 83.1, 83.8, 84.5, 85.1, 85.7, 86.4, 86.9, 87.5, 88.1,
			88.7, 89.2, 89.8, 90.3, 90.9, 91.4, 91.9, 92.4, 93.0, 93.5, 94.0, 94.4, 94.9, 95.4, 95.9, 96.4, 96.9, 97.4,
			97.8, 98.3, 98.8, 99.3, 99.7, 100.2, 100.7 };

	private double[] alturaMaxima2a5Anos = { 93.9, 94.2, 95.2, 96.1, 97.0, 97.9, 98.7, 99.6, 100.4, 101.2, 102.0, 102.7,
			103.5, 104.2, 105.0, 105.7, 106.4, 107.1, 107.8, 108.5, 109.1, 109.8, 110.4, 111.1, 111.7, 112.4, 113.0,
			113.6, 114.2, 114.9, 115.5, 116.1, 116.7, 117.4, 118.0, 118.6, 119.2 };
	
	public double[] getAlturaMax2a5Anos(){
		return alturaMaxima2a5Anos;
	}
	
	public double[] getAlturaMin2a5Anos(){
		return alturaMinima2a5Anos;
	}

	public double[] getPesoMin2a5() {
		return pesoMinimo2a5Anos;
	}

	public double[] getPesoMax2a5() {
		return pesoMaximo2a5Anos;
	}

	public double[] getPesoMin0a2() {
		return pesoMinimo0a2Anos;
	}

	public double[] getPesoMax0a2() {
		return pesoMaximo0a2Anos;
	}

	public double[] getPerimetroMinimo() {
		return perimetroCefalicoMinimo;
	}

	public double[] getPerimetroMaximo() {
		return perimetroCefalicoMaximo;
	}

	public static void main(String[] args) {
		Menino m = new Menino();

		//String s = m.alturaMaxima2a5Anos.replaceAll(",", ".");
		//String g = s.replaceAll("cm", ",");
		System.out.println(m.getAlturaMax2a5Anos().length);
		System.out.println(m.getAlturaMin2a5Anos().length);


	}

}

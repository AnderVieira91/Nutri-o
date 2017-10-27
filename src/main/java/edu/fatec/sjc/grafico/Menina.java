package edu.fatec.sjc.grafico;

public class Menina {
	
	private double[] perimetroCefalicoMinimo = { 31.5, 34.2, 35.8, 37.1, 38.1, 38.9, 39.6, 40.2, 40.7, 41.2, 41.5, 41.9,
			42.2, 42.4, 42.7, 42.9, 43.1, 43.3, 43.5, 43.6, 43.8, 44, 44.1, 44.3, 44.4 };
	
	private double[] perimetroCefalicoMaximo = { 36.2, 38.9, 40.7, 42, 43.1, 44, 44.8, 45.4, 46, 46.5, 46.9, 47.3, 47.6,
			47.9, 48.2, 48.4, 48.6, 48.8, 49, 49.2, 49.4, 49.5, 49.7, 49.8, 50 };

	private double[] pesoMinimo0a2Anos = { 2.4, 3.2, 3.9, 4.5, 5.0, 5.4, 5.7, 6.0, 6.3, 6.5, 6.7, 6.9, 7.0, 7.2, 7.4,
			7.6, 7.7, 7.9, 8.1, 8.2, 8.4, 8.6, 8.7, 8.9, 9.0 };
	private double[] pesoMaximo0a2Anos = { 4.2, 5.5, 6.6, 7.5, 8.2, 8.8, 9.3, 9.8, 10.2, 10.5, 10.9, 11.2, 11.5, 11.8,
			12.1, 12.4, 12.6, 12.9, 13.2, 13.5, 13.7, 14.0, 14.3, 14.6, 14.8 };

	private double[] pesoMinimo2a5Anos = { 9.0, 9.2, 9.4, 9.5, 9.7, 9.8, 10.0, 10.1, 10.3, 10.4, 10.5, 10.7, 10.8, 10.9,
			11.1, 11.2, 11.3, 11.5, 11.6, 11.7, 11.8, 12.0, 12.1, 12.2, 12.3, 12.4, 12.6, 12.7, 12.8, 12.9, 13.0, 13.2,
			13.3, 13.4, 13.5, 13.6, 13.7 };
	private double[] pesoMaximo2a5Anos = { 14.8, 15.1, 15.4, 15.7, 16.0, 16.2, 16.5, 16.8, 17.1, 17.3, 17.6, 17.9, 18.1,
			18.4, 18.7, 19.0, 19.2, 19.5, 19.8, 20.1, 20.4, 20.7, 20.9, 21.2, 21.5, 21.8, 22.1, 22.4, 22.6, 22.9, 23.2,
			23.5, 23.8, 24.1, 24.4, 24.6, 24.9 };

	private double[] alturaMinima2a5Anos = { 80.0, 80.0, 80.8, 81.5, 82.2, 82.9, 83.6, 84.3, 84.9, 85.6, 86.2, 86.8,
			87.4, 88.0, 88.6, 89.2, 89.8, 90.4, 90.9, 91.5, 92.0, 92.5, 93.1, 93.6, 94.1, 94.6, 95.1, 95.6, 96.1, 96.6,
			97.1, 97.6, 98.1, 98.5, 99.0, 99.5, 99.9 };

	private double[] alturaMaxima2a5Anos = { 92.9, 93.1, 94.1, 95.0, 96.0, 96.9, 97.7, 98.6, 99.4, 100.3, 101.1, 101.9,
			102.7, 103.4, 104.2, 105.0, 105.7, 106.4, 107.2, 107.9, 108.6, 109.3, 110.0, 110.7, 111.3, 112.0, 112.7,
			113.3, 114.0, 114.6, 115.2, 115.9, 116.5, 117.1, 117.7, 118.3, 118.9 };

	public double[] getAlturaMax2a5Anos() {
		return alturaMaxima2a5Anos;
	}

	public double[] getAlturaMin2a5Anos() {
		return alturaMinima2a5Anos;
	}

	public double[] getPesoMax2a5() {
		return pesoMaximo2a5Anos;
	}

	public double[] getPesoMin2a5() {
		return pesoMinimo2a5Anos;
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

}

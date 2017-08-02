package edu.fatec.sjc.grafico;

import org.jfree.data.category.DefaultCategoryDataset;

public class Desenho {

	public DefaultCategoryDataset getDs(int idadeInicial, int idadeFinal, double[] minimo, double[] maximo) {

		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		int a = 0;
		for (int i = idadeInicial; i < idadeFinal; i++) {
			for (int j = 0; j < 12; j++) {
				String data = String.valueOf(i) + "/" + String.valueOf(j);
				ds.addValue(maximo[a], "máximo", data);
				ds.addValue(minimo[a], "minimo", data);
				a++;
			}
		}
		String data = String.valueOf(idadeFinal) + "/0";
		ds.addValue(maximo[a], "máximo", data);
		ds.addValue(minimo[a], "minimo", data);

		return ds;
	}

}

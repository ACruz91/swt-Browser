package browser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

import matriz.Matriz;

public class Html {
	public void escribirHtmlAbrir(String fichero, String ficheroHtml) {
		Matriz obj = new Matriz();
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			// Escritura del Fichero
			fw = new FileWriter(ficheroHtml);
			pw = new PrintWriter(fw);
			obj.leer(fichero);
			pw.println("<html>\n\t<head>\n<link rel=\"stylesheet\" href=\"base.css\">\n<script type=\"text/javascript\" src=\"prueba.js\"></script>\t\t<title>\n\n\t\t</title>\n\t</head>\n\t<body>\n\t\t<h1>\n\t\t\t Matriz cargada en "
					+ ficheroHtml + "</h1>\n\t\t\t<center><table>\t\t\t\t");
			for (int i = 0; i < obj.getColumnas(); i++) {
				pw.println("\t\t\t\t<tr>");
				for (int j = 0; j < obj.getFilas(); j++) {
					pw.println("\t\t\t\t<td>" + obj.getMatriz(j, i) + "</td>");
				}
				pw.println("\t\t\t\t</tr>\n");
			}

			pw.println("\t\t\t</table></center>");
			pw.println("\t\t<h2> Estadísticas </h2>");
			pw.println("\t\t\t<ul>");
			pw.println("\t\t\t\t<li> <h3> Número Máximo: " + obj.getMaximo()
					+ "</h3>");
			pw.println("\t\t\t\t<li> <h3> Número Mínimo: " + obj.getMinimo()
					+ "</h3>");
			pw.println("\t\t\t\t<li> <h3> Número Filas: " + obj.getFilas()
					+ "</h3>");
			pw.println("\t\t\t\t<li> <h3> Número Columnas: " + obj.getFilas()
					+ "</h3>");
			pw.println("\t\t\t</ul>");
			pw.println("\t</body>\n</html>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fw)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void escribirHtmlCrear(String fichero, int nFilas, int nColumnas) {
		Matriz obj = new Matriz();
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			// Escritura del Fichero
			fw = new FileWriter(fichero);
			pw = new PrintWriter(fw);
			obj.crear(nFilas, nColumnas);
			pw.println("<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" href=\"base.css\">\n\t\t<script src=\"prueba.js\"></script>\t\t<title>\n\n\t\t</title>\n\t</head>\n\t<body>\n\t\t<h1>Matriz cargada en "
					+ fichero + "</h1>\n\t\t\t<center><table>\t\t\t\t");
			for (int i = 0; i < obj.getColumnas(); i++) {
				pw.println("\t\t\t\t<tr>");
				for (int j = 0; j < obj.getFilas(); j++) {
					pw.println("\t\t\t\t<td>" + obj.getMatriz(j, i) + "</td>");
				}
				pw.println("\t\t\t\t</tr>\n");
			}
			pw.println("\t\t\t</table></center>");
			pw.println("\t\t<h2> Estadísticas </h2>");
			pw.println("\t\t\t<ul>");
			pw.println("\t\t\t\t<li> <h3> Número Máximo: " + obj.getMaximo()
					+ "</h3>");
			pw.println("\t\t\t\t<li> <h3> Número Mínimo: " + obj.getMinimo()
					+ "</h3>");
			pw.println("\t\t\t\t<li> <h3> Número Filas: " + obj.getFilas()
					+ "</h3>");
			pw.println("\t\t\t\t<li> <h3> Número Columnas: " + obj.getFilas()
					+ "</h3>");
			pw.println("\t\t\t</ul>");
			pw.println("\t\t\t<center><button onclick=\"saludo()\"</center>Click</button>");
			pw.println("\t</body>\n</html>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fw)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void leerHtml(String fichero, ArrayList<Browser> arrayListBrowser,
			CTabFolder folder) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			// Lectura del Fichero
			archivo = new File(fichero);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = null;

			// Añadimos un nuevo Browser a nuestra Array
			arrayListBrowser.add(new Browser(folder, SWT.NONE));
			int tamaño = folder.getItems().length - 1;
			folder.getItem(tamaño).setText(fichero);

			// Este String se crea para concatenar todo el fichero leido para
			// que se muestre en el Browser creado
			String resultado = "";
			while ((linea = br.readLine()) != null) {
				resultado += linea;
			}
			// La cadena leida se muestra en el Browser
			arrayListBrowser.get(arrayListBrowser.size() - 1)
			.setText(resultado);
			folder.getItem(tamaño).setControl(
					arrayListBrowser.get(arrayListBrowser.size() - 1));
			arrayListBrowser.get(arrayListBrowser.size() - 1);
			// Creamos una nueva pestaña
			folder.showItem(folder.getItem(tamaño));
			CTabItem itemCrear = new CTabItem(folder, SWT.CLOSE);
			itemCrear.setText("       ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrado del Fichero
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}

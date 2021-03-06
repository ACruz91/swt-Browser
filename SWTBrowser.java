package browser;

import java.util.ArrayList;

import matriz.Matriz;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SWTBrowser {
	/* Par�metros */
	private Shell shell;
	private Menu menuBar, menuMenuArchivo, menuMenuEditar;
	private MenuItem menuButtonArchivo, menuButtonEditar,
	menuButtonNuevaPesta�a, menuButtonSalir, menuButtonAbrir,
	menuButtonNuevo, menuButtonNuevaMatriz, menuButtonAbrirMatriz,
	menuButtonGuardarMatriz, menuButtonNuevoHTMLLocal;

	public void MenuButton(Shell shell, Display display) {
		// Creaci�n del Men�
		menuBar = new Menu(shell, SWT.BAR);
		// Creaci�n de la Cabecera del menuBar, Menu que es un icono
		menuButtonArchivo = new MenuItem(menuBar, SWT.CASCADE);
		menuButtonArchivo.setText("Archivo");

		// Creaci�n del subMen� menuMenu es una cabecera del men� menuBar
		menuMenuArchivo = new Menu(shell, SWT.DROP_DOWN);
		menuButtonArchivo.setMenu(menuMenuArchivo);

		// Creaci�n de la Cabecera del menuBar, Menu que es un icono
		menuButtonEditar = new MenuItem(menuBar, SWT.CASCADE);
		menuButtonEditar.setText("Editar");

		menuMenuEditar = new Menu(shell, SWT.DROP_DOWN);
		menuButtonEditar.setMenu(menuMenuEditar);

		// Creaci�n de un Item del Men�, Nueva Pesta�a
		menuButtonNuevaPesta�a = new MenuItem(menuMenuArchivo, SWT.PUSH);
		menuButtonNuevaPesta�a.setText("&Nueva Pesta�a\t CTRL+T");
		menuButtonNuevaPesta�a.setAccelerator(SWT.CTRL + 'T');
		Image nuevaPesta�a = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/addition6.png"));
		menuButtonNuevaPesta�a.setImage(nuevaPesta�a);

		// Separador
		new MenuItem(menuMenuArchivo, SWT.SEPARATOR);
		
		// Creaci�n de un Item del Men�, para crear una HTML Local
		menuButtonNuevoHTMLLocal = new MenuItem(menuMenuArchivo, SWT.PUSH);
		menuButtonNuevoHTMLLocal.setText("&Nuevo HTML Local\t CTRL+L");
		menuButtonNuevoHTMLLocal.setAccelerator(SWT.CTRL + 'L');
		Image nuevoHTMLLocal = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/html8.png"));
		menuButtonNuevoHTMLLocal.setImage(nuevoHTMLLocal);
		
		// Separador
		new MenuItem(menuMenuArchivo, SWT.SEPARATOR);

		// Creaci�n de un Item del Men�, Nuevo
		menuButtonNuevo = new MenuItem(menuMenuArchivo, SWT.PUSH);
		menuButtonNuevo.setText("&Nuevo\t CTRL+N");
		menuButtonNuevo.setAccelerator(SWT.CTRL + 'N');
		Image nuevo = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/text70.png"));
		menuButtonNuevo.setImage(nuevo);

		// Creaci�n de un Item del Men�, Abrir
		menuButtonAbrir = new MenuItem(menuMenuArchivo, SWT.PUSH);
		menuButtonAbrir.setText("&Abrir\t CTRL+O");
		menuButtonAbrir.setAccelerator(SWT.CTRL + 'O');
		Image abrir = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/open131.png"));
		menuButtonAbrir.setImage(abrir);

		// Separador
		// Create the first separator
		new MenuItem(menuMenuArchivo, SWT.SEPARATOR);

		// Creaci�n de un Item del Men�, Nueva Matriz
		menuButtonNuevaMatriz = new MenuItem(menuMenuArchivo, SWT.PUSH);
		menuButtonNuevaMatriz.setText("&Nueva Matriz\t CTRL+M");
		menuButtonNuevaMatriz.setAccelerator(SWT.CTRL + 'M');
		Image nuevaMatriz = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/folder228.png"));
		menuButtonNuevaMatriz.setImage(nuevaMatriz);

		// Creaci�n de un Item del Men�, Abrir Matriz
		menuButtonAbrirMatriz = new MenuItem(menuMenuArchivo, SWT.PUSH);
		menuButtonAbrirMatriz.setText("&Abrir Matriz\t CTRL+A");
		menuButtonAbrirMatriz.setAccelerator(SWT.CTRL + 'A');
		Image abrirMatriz = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/folder243.png"));
		menuButtonAbrirMatriz.setImage(abrirMatriz);

		// Creaci�n de un Item del Men�, Guardar Matriz
		menuButtonGuardarMatriz = new MenuItem(menuMenuArchivo, SWT.PUSH);
		menuButtonGuardarMatriz.setText("&Guardar Matriz\t CTRL+G");
		menuButtonGuardarMatriz.setAccelerator(SWT.CTRL + 'G');
		Image guardarMatriz = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/save23.png"));
		menuButtonGuardarMatriz.setImage(guardarMatriz);
		// Separador
		new MenuItem(menuMenuArchivo, SWT.SEPARATOR);

		// Creaci�n de un Item del Men�, Salir
		menuButtonSalir = new MenuItem(menuMenuArchivo, SWT.PUSH);
		menuButtonSalir.setText("&Salir\t CTRL+Q");
		menuButtonSalir.setAccelerator(SWT.CTRL + 'Q');
		Image salir = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/door13.png"));
		menuButtonSalir.setImage(salir);


		shell.setMenuBar(menuBar);
	}

	public void TabBrowser(Shell shell, Display display, CTabFolder folder,
			ArrayList<Browser> arrayListBrowser) {
		// Layaout para el Tab
		Composite composite = new Composite(shell, SWT.ON_TOP);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 7;
		composite.setLayout(gridLayout);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		composite.setLayoutData(gridData);

		// Button Back para volver un paso atr�s
		Button buttonBack = new Button(composite, SWT.ICON);
		Image back = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/arrowhead7.png"));
		buttonBack.setImage(back);

		// Button Forward para ir hacia delante
		Button buttonForward = new Button(composite, SWT.ICON);
		Image forward = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/arrow487.png"));
		buttonForward.setImage(forward);

		// Button para recargar la p�gina web
		Button buttonReload = new Button(composite, SWT.ICON);
		Image reload = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/arrows64.png"));
		buttonReload.setImage(reload);

		// Button para volver a nuestro Home
		Button buttonHome = new Button(composite, SWT.ICON);
		Image home = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/home168.png"));
		buttonHome.setImage(home);

		// Text para indicar a la p�gina que est� seleccionada mediante las
		// pesta�as la p�gina que quieras acceder
		final Text url = new Text(composite, SWT.BORDER);
		url.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		url.setFocus();

		// Button para parar el cargado de la P�gina
		Button buttonStop = new Button(composite, SWT.ICON);
		Image stop = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/delete30.png"));
		buttonStop.setImage(stop);

		// Button para hacertar el formulario de b�squeda del navegador
		Button buttonGo = new Button(composite, SWT.ICON);
		Image go = new Image(display,
				SWTBrowser.class.getResourceAsStream("iconos/right39.png"));
		buttonGo.setImage(go);

		buttonBack.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				arrayListBrowser.get(folder.getSelectionIndex()).back();
			}
		});

		buttonGo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				arrayListBrowser.get(folder.getSelectionIndex()).setUrl(
						url.getText());

			}
		});

		buttonReload.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				arrayListBrowser.get(folder.getSelectionIndex()).refresh();
			}
		});

		buttonHome.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				arrayListBrowser.get(folder.getSelectionIndex()).setUrl(
						"http://google.es");
			}
		});

		buttonForward.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				arrayListBrowser.get(folder.getSelectionIndex()).forward();
			}
		});

		buttonStop.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				arrayListBrowser.get(folder.getSelectionIndex()).stop();
			}
		});

		MenuButton(shell, display);
	}

	public void FuncionesMenu(Shell shell, Display display, CTabFolder folder,
			ArrayList<Browser> arrayListBrowser) {
		class salir implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				// Creaci�n de un Dialogo para Salir del programa
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION
						| SWT.YES | SWT.NO);
				messageBox.setMessage(" Seguro que desea Salir?");
				messageBox.setText("Salir");
				int response = messageBox.open();
				if (response == SWT.YES)
					System.exit(0);
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		}

		class nuevaPesta�a implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				int tama�o = folder.getItems().length - 1;
				folder.getItem(tama�o).setText("Nueva Pesta�a");
				arrayListBrowser.add(new Browser(folder, SWT.NONE));
				arrayListBrowser.get(arrayListBrowser.size() - 1).setUrl(
						"http://google.es");
				folder.getItem(tama�o).setControl(
						arrayListBrowser.get(arrayListBrowser.size() - 1));
				folder.showItem(folder.getItem(tama�o));
				CTabItem itemCrear = new CTabItem(folder, SWT.CLOSE);
				itemCrear.setText("       ");

			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		}

		class nuevoHTMLLocal implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				Html objHtml = new Html();
				objHtml.escribirHtmlEjemplo(arrayListBrowser, folder);

			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		}
		class abrir implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				// Creaci�n de un Dialogo para Abrir documentos
				Html objHtml = new Html();
				FileDialog fd = new FileDialog(shell, SWT.OPEN | SWT.CLOSE);
				fd.setFilterPath("C:/");
				String[] filterExt = { "*.html", "*.htm", "*.*" };
				fd.setFilterExtensions(filterExt);
				String fichero = fd.open();

				// Si Existe el Fichero
				if (fichero != null) {
					objHtml.leerHtml(fichero, arrayListBrowser, folder);
				}
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		}

		class nuevo implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				// Creaci�n de una Shell hija llamada "nuevo" para el nuevo
				// dialogo
				Shell nuevo = new Shell(shell, SWT.DIALOG_TRIM);

				// Caracter�sticas de la Ventana "Nuevo"
				nuevo.setSize(500, 500);
				nuevo.setText("Nuevo");

				// GridData para la Ventana "Nuevo"
				nuevo.setLayout(new GridLayout(1, false));
				GridData gridData = new GridData();
				gridData.verticalAlignment = GridData.FILL;
				gridData.grabExcessVerticalSpace = true;
				gridData.horizontalAlignment = GridData.FILL;
				gridData.grabExcessHorizontalSpace = true;

				// Creaci�n del StyledText para crear un nuevo archivo .html
				StyledText text = new StyledText(nuevo, SWT.BORDER
						| SWT.H_SCROLL | SWT.V_SCROLL);
				text.setText("<html>\n\t<head>\n\t\t<title>\n\n\t\t</title>\n\t</head>\n\t\t<body>\n\n\t\t</body>\n</html>");
				text.setLayoutData(gridData);

				// Creaci�n de una Composici�n para alinear los dos botones
				Composite composite = new Composite(nuevo, SWT.NONE);
				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 2;
				composite.setLayout(gridLayout);
				GridData gridDataBotton = new GridData();
				gridDataBotton.horizontalAlignment = SWT.CENTER;
				gridDataBotton.grabExcessHorizontalSpace = true;
				composite.setLayoutData(gridDataBotton);

				// Button para Aceptar el nuevo archivo .html
				Button buttonAceptar = new Button(composite, SWT.PUSH);
				buttonAceptar.setText("Aceptar");
				buttonAceptar.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent event) {
						// Para guardar el html en un Browser
						String html;
						html = text.getText();

						int tama�o = folder.getItems().length - 1;
						folder.getItem(tama�o).setText("Untitled ");
						arrayListBrowser.add(new Browser(folder, SWT.NONE));
						arrayListBrowser.get(arrayListBrowser.size() - 1)
						.setText(html);
						folder.getItem(tama�o)
						.setControl(
								arrayListBrowser.get(arrayListBrowser
										.size() - 1));
						folder.showItem(folder.getItem(tama�o));
						CTabItem itemCrear = new CTabItem(folder, SWT.CLOSE);
						itemCrear.setText("       ");
						nuevo.close();
					}

					public void widgetDefaultSelected(SelectionEvent event) {

					}
				});

				// Creaci�n de Button para cancelar el nuevo Fichero
				Button buttonCancelar = new Button(composite, SWT.PUSH);
				buttonCancelar.setText("Cancelar");
				buttonCancelar.pack();
				buttonCancelar.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent event) {
						nuevo.close();
					}

					public void widgetDefaultSelected(SelectionEvent event) {

					}
				});

				nuevo.open();

			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		}

		class nuevaMatriz implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				// Creaci�n de una Shell hija llamada "nuevo" para el nuevo
				// dialogo
				Shell nuevo = new Shell(shell, SWT.DIALOG_TRIM);

				// Caracter�sticas de la Ventana "Nuevo"
				nuevo.setSize(300, 120);
				nuevo.setText("Nuevo");

				// Layout de la Ventana
				nuevo.setLayout(new GridLayout(3, true));
				GridData gridData = new GridData(GridData.CENTER);
				gridData.horizontalSpan = 2;

				// Creaci�n del Label y Text para pedir las nFilas
				Label labelFilas = new Label(nuevo, SWT.LEFT);
				labelFilas.setText("Introduzca el n�mero de Filas: ");
				Text textFilas = new Text(nuevo, SWT.SINGLE | SWT.BORDER);
				textFilas.setLayoutData(gridData);
				textFilas.computeSize(5, 5);

				// Creaci�n del Label y Text para pedir las nColumnas
				Label labelColumnas = new Label(nuevo, SWT.LEFT);
				labelColumnas.setText("Introduzca el n�mero de Columnas: ");
				Text textColumnas = new Text(nuevo, SWT.SINGLE | SWT.BORDER);
				textColumnas.setLayoutData(gridData);

				// Creaci�n de Button para aceptar nFilas y nColumnas
				Button buttonAceptar = new Button(nuevo, SWT.PUSH);
				buttonAceptar.setText("Aceptar");
				buttonAceptar.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent event) {
						Matriz objMatriz = new Matriz();
						Html objHtml = new Html();
						// Obtenemos nFilas y nColumnas de los Text y creamos la
						// Matriz
						objMatriz.setFilas(Integer.parseInt(textFilas.getText()));
						objMatriz.setColumnas(Integer.parseInt(textColumnas
								.getText()));

						// Valores por Defecto en caso de 0 o menos
						if (objMatriz.getFilas() <= 0) {
							objMatriz.setFilas(1);
						}
						if (objMatriz.getColumnas() <= 0) {
							objMatriz.setColumnas(1);
						}

						// Pedimos al usuario donde le gustar�a guardar el
						// Fichero
						FileDialog fd = new FileDialog(shell, SWT.OPEN
								| SWT.CLOSE);
						fd.setFilterPath("C:/");
						String[] filterExt = { "*.html", "*.*" };
						fd.setFilterExtensions(filterExt);
						String fichero = fd.open();

						// Si Existe el Fichero
						if (fichero != null) {
							objHtml.escribirHtmlCrear(fichero,
									objMatriz.getFilas(),
									objMatriz.getColumnas());
							objHtml.leerHtml(fichero, arrayListBrowser, folder);
						}

						nuevo.close();
					}

					public void widgetDefaultSelected(SelectionEvent event) {
					}
				});

				// Creaci�n de Button para cancelar nFilas y nColumnas
				Button buttonCancelar = new Button(nuevo, SWT.PUSH);
				buttonCancelar.setText("Cancelar");
				buttonCancelar.pack();
				buttonCancelar.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent event) {
						nuevo.close();
					}

					public void widgetDefaultSelected(SelectionEvent event) {

					}
				});

				nuevo.open();
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		}

		class abrirMatriz implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				// Creaci�n de un Dialogo para Abrir documentos
				Html objHtml = new Html();
				FileDialog fd = new FileDialog(shell, SWT.OPEN | SWT.CLOSE);
				fd.setFilterPath("C:/");
				String[] filterExt = { "*.txt", "*.*" };
				fd.setFilterExtensions(filterExt);
				String fichero = fd.open();

				// Si Existe el Fichero
				if (fichero != null) {
					// Este proceso es para quitarle la extensi�n al nombre y
					// ponerle la extensi�n html
					String resultado = "";
					String ficheroHtml = null;
					for (int i = 0; i < fichero.length() - 4; ++i) {
						resultado += fichero.charAt(i);
					}

					ficheroHtml = resultado.concat(".html");
					// Creamos el archivo.html y luego leemos para poder meterlo
					// en un Browser
					objHtml.escribirHtmlAbrir(fichero, ficheroHtml);
					objHtml.leerHtml(ficheroHtml, arrayListBrowser, folder);
				}
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		}

		class guardarMatriz implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				// Creaci�n de un Dialogo para Abrir documentos
				FileDialog fd = new FileDialog(shell, SWT.OPEN | SWT.CLOSE);
				fd.setFilterPath("C:/");
				String[] filterExt = { "*.html", "*.htm", "*.*" };
				fd.setFilterExtensions(filterExt);
				String fichero = fd.open();

				// Si Existe el Fichero
				if (fichero != null) {
					int tama�o = folder.getItems().length - 1;
					folder.getItem(tama�o).setText("Nueva Pesta�a");
					arrayListBrowser.add(new Browser(folder, SWT.NONE));
					arrayListBrowser.get(arrayListBrowser.size() - 1);
					folder.getItem(tama�o).setControl(
							arrayListBrowser.get(arrayListBrowser.size() - 1));
					arrayListBrowser.get(arrayListBrowser.size() - 1);
					folder.showItem(folder.getItem(tama�o));
					CTabItem itemCrear = new CTabItem(folder, SWT.CLOSE);
					itemCrear.setText("       ");
				}
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		}
		// Asignaci�n de Funciones de menuArchivo
		menuButtonNuevo.addSelectionListener(new nuevo());
		menuButtonAbrir.addSelectionListener(new abrir());
		menuButtonSalir.addSelectionListener(new salir());
		menuButtonNuevoHTMLLocal.addSelectionListener(new nuevoHTMLLocal());
		menuButtonNuevaPesta�a.addSelectionListener(new nuevaPesta�a());
		menuButtonNuevaMatriz.addSelectionListener(new nuevaMatriz());
		menuButtonAbrirMatriz.addSelectionListener(new abrirMatriz());
		menuButtonGuardarMatriz.addSelectionListener(new guardarMatriz());

	}

	public void Pesta�as(Shell shell, Display display, CTabFolder folder,
			ArrayList<Browser> arrayListBrowser) {
		// Creaci�n del Item del TabItem que ser� el primero
		CTabItem itemInicial = new CTabItem(folder, SWT.CLOSE);
		itemInicial.setText("Google");
		arrayListBrowser.add(new Browser(folder, SWT.NONE));
		arrayListBrowser.get(0).setUrl("http://google.es");
		itemInicial.setControl(arrayListBrowser.get(0));
		folder.showItem(itemInicial);

		// Creaci�n del Item que crear� las nuevas Pesta�as
		CTabItem itemCrear = new CTabItem(folder, SWT.CLOSE);
		itemCrear.setText("        ");

		folder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (folder.getSelection() == folder.getItem(folder.getItems().length - 1)
						&& folder.getSelection() != folder.getItem(0)) {
					folder.getSelection().setText("Nueva Pesta�a");
					arrayListBrowser.add(new Browser(folder, SWT.NONE));
					arrayListBrowser.get(folder.getSelectionIndex()).setUrl(
							"http://google.es");
					folder.getSelection().setControl(
							arrayListBrowser.get(folder.getSelectionIndex()));
					folder.showItem(folder.getSelection());
					CTabItem itemCrear = new CTabItem(folder, SWT.CLOSE);
					itemCrear.setText("       ");
					folder.getSelection().setControl(
							arrayListBrowser.get(folder.getSelectionIndex()));
				}
			}
		});
		
	}

	public void Ventana() {
		// Par�metros
		SWTBrowser obj = new SWTBrowser();

		// Creaci�n del display y shell
		Display display = new Display();
		Shell shell = new Shell(display);

		// Caracter�sticas Shell
		shell.setText("Navegador Web");
		shell.setMaximized(true);
		shell.setLayout(new GridLayout(1, false));

		// Creaci�n de una ArrayList de Browser para que cada pesta�a le
		// corresponda una nueva pagina web
		ArrayList<Browser> arrayListBrowser = new ArrayList<Browser>();

		// Creaci�n del Folder que contendr� las pesta�as del Navegador
		CTabFolder folder = new CTabFolder(shell, SWT.BORDER);

		// Grid para el Folder
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		folder.setLayoutData(gridData);

		// Llamadas a las Funciones creadas anteriormente
		obj.TabBrowser(shell, display, folder, arrayListBrowser);
		obj.Pesta�as(shell, display, folder, arrayListBrowser);
		obj.MenuButton(shell, display);
		obj.FuncionesMenu(shell, display, folder, arrayListBrowser);

		// Apertura de la shell
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public static void main(String args[]) {
		SWTBrowser obj = new SWTBrowser();
		obj.Ventana();

	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Menu getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(Menu menuBar) {
		this.menuBar = menuBar;
	}

}

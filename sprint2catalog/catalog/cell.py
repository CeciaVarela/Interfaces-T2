import gi
from detail_window import DetailWindow
gi.require_version("Gtk","3.0")
from gi.repository import Gtk

class Cell(Gtk.EventBox):
	name = None
	
	def __init__(self, name, image):
		super().__init__()
		self.name = name
		box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=4)
		box.pack_start(Gtk.Label(label=name), False, False, 0)
		box.pack_start(image, True, True, 0)
		self.add(box)
		self.connect("button_release_event", self.on_click,image)
		
	def on_click(self, widget, event,image):
		 
		description = Gtk.Label()
		nuevaImagen=Gtk.Image()
		nuevaImagen.set_from_pixbuf(image.get_pixbuf())
		
		if self.name=="Mapache":
			name=Gtk.Label("Mapache")
			description = Gtk.Label( "Es un animal de tamaño similar al de un gato, que mide entre 40 y 70 centímetros de longitud y pesa entre 2 y 14 kilogramos. ")
		elif self.name=="Lobo":
			name=Gtk.Label("Lobo")
			description = Gtk.Label ( "Son animales cuadrúpedos, mamíferos, con cuerpos de entre 60 y 90 cm de alto y un peso de entre 32 y 70 kg. Suelen medir entre 1,30 y 2 metros de largo. Poseen una cola larga, y no son, en principio, demasiado diferentes anatómicamente de un perro.")
		elif self.name=="Oso panda":
			name=Gtk.Label("Oso panda")
			description = Gtk.Label ("Miden unos 150 cm de largo, más unos 10-15 cm de cola. Un panda adulto puede llegar a pesar hasta 150 kg, siendo los machos un 10% mayores y un 20% más pesados que las hembras. Poseen un pelaje blanco con partes negras alrededor de los ojos, en las orejas, hocico, hombros y extremidades.")
		elif self.name=="Tucán":
			name=Gtk.Label("Tucán")
			description = Gtk.Label ("Son aves de plumas y pico de colores muy llamativos. Miden 65 centímetros y pesan de 130 hasta 680 g. Su pico es largo con una longitud aproximada de 20 cm y alcanzando su talla definitiva después de varios meses.")
		elif self.name=="Vaca":
			name=Gtk.Label("Vaca")
			description = Gtk.Label ("Se trata de un animal mamífero que pertenece a la familia de los bóvidos. La vaca, que forma parte de los artiodáctilos (ya que sus extremidades culminan en una cantidad par de dedos), es herbívora")
		else:
			description = Gtk.Label("hola")
		animal=DetailWindow(name,nuevaImagen,description)
		animal.show_all()
		

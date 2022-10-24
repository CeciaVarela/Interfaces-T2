import gi
from gi.repository import GdkPixbuf
gi.require_version("Gtk","3.0")
from gi.repository import Gtk
from cell import Cell 

class MainWindow(Gtk.Window):
	flowbox = Gtk.FlowBox()
	
	def __init__(self):
		super().__init__(title="Catálogo")
		self.connect("destroy",Gtk.main_quit)
		self.set_border_width(15)
		self.set_default_size(200,200)
		
		header = Gtk.HeaderBar(title="Animales")
		header.set_subtitle("Catálogo 2022")
		header.props.show_close_button = True
		
		self.set_titlebar(header)
		
		scrolled = Gtk.ScrolledWindow()
		scrolled.set_policy(Gtk.PolicyType.NEVER, Gtk.PolicyType.AUTOMATIC)
		scrolled.add(self.flowbox)
		self.add(scrolled)
		
		image = Gtk.Image()
		pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/animal1.jpg", 200, 200, False)
		image.set_from_pixbuf(pixbuf)
		cell_one = Cell("Mapache",image)
		image = Gtk.Image()
		pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/animal2.jpg", 200, 200, False)
		image.set_from_pixbuf(pixbuf)
		cell_two = Cell("Lobo",image)
		image = Gtk.Image()
		pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/animal3.jpg", 200, 200, False)
		image.set_from_pixbuf(pixbuf)
		cell_three = Cell("Oso panda",image)
		image = Gtk.Image()
		pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/animal4.jpg", 200, 200, False)
		image.set_from_pixbuf(pixbuf)
		cell_four = Cell("Tucán",image)
		image = Gtk.Image()
		pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/animal5.jpg", 200, 200, False)
		image.set_from_pixbuf(pixbuf)
		cell_five = Cell("Vaca",image)
		self.flowbox.add(cell_one)
		self.flowbox.add(cell_two)
		self.flowbox.add(cell_three)
		self.flowbox.add(cell_four)
		self.flowbox.add(cell_five)

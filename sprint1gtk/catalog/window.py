import gi
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
		
		cell_one = Cell("Mapache", Gtk.Image.new_from_file("data/edited/animal1.jpg"))
		cell_two = Cell("Lobo",Gtk.Image.new_from_file("data/edited/animal2.jpg"))
		cell_three = Cell("Oso panda",Gtk.Image.new_from_file("data/edited/animal3.jpg"))
		cell_four = Cell("Tucán",Gtk.Image.new_from_file("data/edited/animal4.jpg"))
		cell_five = Cell("Vaca",Gtk.Image.new_from_file("data/edited/animal5.jpg"))
		self.flowbox.add(cell_one)
		self.flowbox.add(cell_two)
		self.flowbox.add(cell_three)
		self.flowbox.add(cell_four)
		self.flowbox.add(cell_five)

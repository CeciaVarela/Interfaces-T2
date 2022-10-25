import gi
from gi.repository import GdkPixbuf
gi.require_version("Gtk","3.0")
from gi.repository import Gtk
from cell import Cell 

class MainWindow(Gtk.Window):
	flowbox = Gtk.FlowBox()
	
	def __init__(self,data_source):
		super().__init__(title="Catálogo")
		self.connect("destroy",Gtk.main_quit)
		self.set_border_width(15)
		self.set_default_size(400,400)
		
		header = Gtk.HeaderBar(title="Animales")
		header.set_subtitle("Catálogo 2022")
		header.props.show_close_button = True
		
		self.set_titlebar(header)
		
		scrolled = Gtk.ScrolledWindow()
		scrolled.set_policy(Gtk.PolicyType.NEVER, Gtk.PolicyType.AUTOMATIC)
		scrolled.add(self.flowbox)
		self.add(scrolled)
		
		for item in data_source:
			cell = Cell(item.get("name"), item.get("gtk_image"))
			self.flowbox.add(cell)

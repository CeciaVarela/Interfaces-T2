import gi
gi.require_version("Gtk","3.0")
from gi.repository import Gtk

class DetailWindow(Gtk.Window):
	def __init__(self,title,imagen,description):
		box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL)
		super().__init__()
		box.pack_start(title, True, True,0)
		box.pack_start(imagen, True, True,0)
		box.pack_start(description, True, True,0)
		self.add(box)
		"""" Lo ajusto en el centro al iniciarlo y le doy un tamaño y un borde"""
		self.set_position(Gtk.WindowPosition.CENTER)
		self.set_default_size(500, 300)
		self.set_border_width(15)

	
	

	

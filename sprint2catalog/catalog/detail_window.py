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

	
	

	

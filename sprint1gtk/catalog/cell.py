import gi
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
		self.connect("button_release_event", self.on_click)
		
	def on_click(self, widget, event):
		print("Se ha clicado la celda de " + self.name)

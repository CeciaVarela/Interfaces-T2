import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class MainWindow(Gtk.Window):
	image = Gtk.Image.new_from_file("animal1.jpg")
	
	def __init__(self):
			super().__init__(tittle="Alert")
			self.connect("destroy", Gtk.main_quit)
			self.add(self.image)


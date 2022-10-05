import gi
gi.require_version("Gtk","3.0")
from gi.repository import Gtk

class No_Window(Gtk.Window):
	label = Gtk.Label("Tu respuesta es no")
	def __init__(self):
		super().__init__(title="Main")
		self.add(self.label)


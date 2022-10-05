import gi
gi.require_version("Gtk","3.0")
from gi.repository import Gtk
from yes_window import Yes_Window
from no_window import No_Window

class MainWindow(Gtk.Window):
	box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL)
	label = Gtk.Label("Elige opción")
	box2 = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL)
	button = Gtk.Button(label="Si")
	button2 = Gtk.Button(label="No")
	 
	def __init__(self):
		super().__init__(title="Main")
		self.connect("destroy", Gtk.main_quit)
		self.button.connect("clicked", self.on_button_clicked)
		self.button2.connect("clicked", self.on_button2_clicked)
		self.add(self.box) 
		self.box.pack_start(self.label, True, True, 0)
		self.box.pack_start(self.box2, True, True, 0)
		self.box2.pack_start(self.button, True, True, 0)
		self.box2.pack_start(self.button2, True, True, 0)
        
	def on_button_clicked(self,widget):
		yw = Yes_Window()
		yw.show_all()
	
	def on_button2_clicked(self,widget):
		nw = No_Window()
		nw.show_all()


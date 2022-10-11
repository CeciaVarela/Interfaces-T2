import gi
gi.require_version("Gtk","3.0")
from gi.repository import Gtk
from Window import Main 
win = MainWindow()
win.show_all()

Gtk.main()

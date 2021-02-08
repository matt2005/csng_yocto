require recipes-qt/qt5/qt5.inc

DESCRIPTION = "Qt plugins for GStreamer 1.0"
SECTION = "multimedia"
LICENSE = "LGPLv2.1"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base cmake boost qtbase qtdeclarative qtmultimedia glib-2.0-native"

inherit cmake_qt5

PACKAGECONFIG ??= "examples"
PACKAGECONFIG[examples] = "-DQTGSTREAMER_EXAMPLES=ON, -DQTGSTREAMER_EXAMPLES=OFF"

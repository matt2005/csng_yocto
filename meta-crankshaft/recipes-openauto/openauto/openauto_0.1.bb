SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "OpenAuto" 
LICENSE = "GPL-3.0" 
LIC_FILES_CHKSUM = "file://../git/CMakeLists.txt;md5=8a99c155d021c9bd1fc088fdd7340b98"
SRC_URI = "git://github.com/opendsh/openauto.git;protocol=https;branch=develop"
SRCREV = "develop"
DEPENDS += " aasdk pulseaudio taglib librtaudio"
inherit cmake_qt5
EXTRA_OECMAKE += '-DCMAKE_BUILD_TYPE=Release -DRPI_BUILD=TRUE ../git'

 
# this is a revision number that should be updated every time you alter this recipe
PR = "r1" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/openauto"

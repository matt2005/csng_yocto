SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "OpenAuto" 
LICENSE = "GPL-3.0" 
LIC_FILES_CHKSUM = "file://../git/Readme.md;md5=32ef6748de2f0d2a39f812e1f6a0cb78"
SRC_URI = "git://github.com/matt2005/openauto.git;protocol=https;branch=yocto"
SRCREV = "yocto"
DEPENDS += " aasdk pulseaudio gpsd taglib util-linux librtaudio"
inherit cmake_qt5
EXTRA_OECMAKE += '-DCMAKE_BUILD_TYPE=Release -DRPI3_BUILD=TRUE ../git'

 
# this is a revision number that should be updated every time you alter this recipe
PR = "r0" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/openauto"

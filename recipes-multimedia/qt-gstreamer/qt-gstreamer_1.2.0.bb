include qt-gstreamer.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = " \
    git://github.com/detrout/qt-gstreamer.git;branch=master;protocol=http \
    "
SRCREV = "master"

S = "${WORKDIR}/git"

export EXTRA_OECMAKE = "-DQT_VERSION=5 \
"

EXTRA_OECONF += "--disable-rpath"

#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
#INHIBIT_PACKAGE_STRIP = "1"


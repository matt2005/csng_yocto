include qt-gstreamer.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = " \
    git://github.com/GStreamer/qt-gstreamer.git;branch=master;protocol=http \
    "
SRCREV = "master"

S = "${WORKDIR}/git"

export EXTRA_OECMAKE = "-DQT_VERSION=5 \
"

EXTRA_OECONF += "--disable-rpath"

#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
#INHIBIT_PACKAGE_STRIP = "1"
FILES_${PN} += "\
    ${libdir}/gstreamer-1.0/* \
    ${B}/usr/lib/qml/QtGStreamer/** \
"

#FILES_${PN}-dbg += "\
#    ${libdir}/gstreamer-1.0/.debug/* \
#"

#FILES_${PN}-dev += "${libdir}/cmake/* ${libdir}/cmake/QtGStreamer/*"

#FILES_${PN}-examples += " \
#    ${libdir}/qt5/examples/${PN}/* \
#"

#do_install_append() {
#    mkdir -p ${D}/usr/share/qt5/examples/qt-gstreamer/
#    install ${B}/examples/qmlplayer2/qmlplayer2 ${D}/usr/share/qt5/examples/qt-gstreamer/
#    install -d ${D}${datadir}/qt5/examples/${P}
#    install -m 0755 ${B}/examples/qmlplayer2/qmlplayer2 ${D}${datadir}/qt5/examples/${P}
#}



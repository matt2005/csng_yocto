include qt-gstreamer.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = " \
    git://github.com/detrout/qt-gstreamer.git;branch=master;protocol=http \
    "
SRCREV = "e2ca8094aa8d0eac1c3a98df66fe94ce0c754088"

S = "${WORKDIR}/git"

export EXTRA_OECMAKE = "-DQT_VERSION=5 \
    -DUSE_QT_PLUGIN_DIR=OFF \
    -DCMAKE_SKIP_INSTALL_RPATH=YES \
    -DCMAKE_SKIP_RPATH=YES \
    -DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/usr/bin/qt5/ \
"

EXTRA_OECONF += "--disable-rpath"

#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
#INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} += "\
    ${libdir}/gstreamer-1.0/* \
"

FILES_${PN}-dbg += "\
    ${libdir}/gstreamer-1.0/.debug/* \
"

FILES_${PN}-dev += "${libdir}/cmake/* ${libdir}/cmake/QtGStreamer/*"

FILES_${PN}-examples += " \
    ${libdir}/qt5/examples/${PN}/* \
"

do_install_append() {
    mkdir -p ${D}/usr/share/qt5/examples/qt-gstreamer/
    install ${B}/examples/qmlplayer2/qmlplayer2 ${D}/usr/share/qt5/examples/qt-gstreamer/
    install -d ${D}${datadir}/qt5/examples/${P}
    install -m 0755 ${B}/examples/qmlplayer2/qmlplayer2 ${D}${datadir}/qt5/examples/${P}
}

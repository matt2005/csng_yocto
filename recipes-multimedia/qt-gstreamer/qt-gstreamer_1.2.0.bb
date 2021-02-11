include qt-gstreamer.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = " \
    git://github.com/GStreamer/qt-gstreamer.git;branch=master;protocol=http \
    "
SRCREV = "master"

S = "${WORKDIR}/git"

export EXTRA_OECMAKE = " -DQT_VERSION=5 \
                        -DUSE_GST_PLUGIN_DIR=ON \
                        -DUSE_QT_PLUGIN_DIR=ON \
                        "

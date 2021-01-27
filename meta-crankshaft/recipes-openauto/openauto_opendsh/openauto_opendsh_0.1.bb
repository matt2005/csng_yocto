SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "OpenAuto- opendsh" 
LICENSE = "GPL-3.0" 
LIC_FILES_CHKSUM = "file://../git/Readme.md;md5=32ef6748de2f0d2a39f812e1f6a0cb78"
SRC_URI = "git://github.com/opendsh/openauto.git;protocol=https;branch=crankshaft-ng"
SRCREV = "develop"
DEPENDS += " aasdk pulseaudio gpsd taglib util-linux"
DEPENDS += " gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-bad gstreamer1.0-libav"
inherit cmake
EXTRA_OECMAKE += '-DCMAKE_BUILD_TYPE=Release -DRPI_BUILD=TRUE -DAASDK_INCLUDE_DIRS="${WORKDIR}/../aasdk/include" -DAASDK_LIBRARIES="${D}${bindir}/libaasdk.so" -DAASDK_PROTO_INCLUDE_DIRS="${WORKDIR}/../aasdk" -DAASDK_PROTO_LIBRARIES="${D}${bindir}/libaasdk_proto.so" ../git'

 
# this is a revision number that should be updated every time you alter this recipe
PR = "r0" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/openauto"

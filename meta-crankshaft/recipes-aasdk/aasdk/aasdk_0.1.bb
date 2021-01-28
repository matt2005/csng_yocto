SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "AndroidAuto SDK" 
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://../git/CMakeLists.txt;md5=2a71911262da0e390c161bb44d29f979"
SRC_URI = "git://github.com/matt2005/aasdk.git;protocol=https;branch=yocto_fix"
SRCREV = "yocto_fix"
DEPENDS += " protobuf protobuf-native boost libusb"
inherit cmake
EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release ../git"
# this is a revision number that should be updated every time you alter this recipe
PR = "r1" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/aasdk"

# this command will be run to compile your source code. it assumes you are in the
# directory indicated by S. i'm just going to use make and rely on my Makefile
#do_compile () {
#  cmake -DCMAKE_BUILD_TYPE=Release ../git
#  make -j2
#}
 
# this will copy the compiled file and place it in ${bindir}, which is /usr/bin
#do_install () {
#  install -d ${D}${libdir}
#  install -m 0755 libaasdk.so ${D}${libdir}
#  install -m 0755 libaasdk_proto.so ${D}${libdir}
#}

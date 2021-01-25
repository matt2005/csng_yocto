SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "AndroidAuto SDK" 
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://../git/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
SRC_URI = "git://github.com/opencardev/aasdk.git;protocol=https;branch=development"
SRCREV = "development"
DEPENDS = ""
inherit cmake make
EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release ../aasdk"
# this is a revision number that should be updated every time you alter this recipe
PR = "r0" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/aasdk_build"

# this command will be run to compile your source code. it assumes you are in the
# directory indicated by S. i'm just going to use make and rely on my Makefile
do_compile () {
  cmake -DCMAKE_BUILD_TYPE=Release ../aasdk
  make -j2
}
 
# this will copy the compiled file and place it in ${bindir}, which is /usr/bin
do_install () {
  install -d ${D}${libdir}
  install -m 0755 libaasdk.so ${D}${libdir}
  install -m 0755 libaasdk_proto.so ${D}${libdir}
}

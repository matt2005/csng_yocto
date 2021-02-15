DESCRIPTION = "Crankshaft settings"
SECTION = "tools"
LICENSE = "MIT"
HOMEPAGE = "https://get-crankshaft.com"

DEPENDS = "openauto"

PR = "r0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "https://raw.githubusercontent.com/opencardev/crankshaft/crankshaft-ng/stage3/03-crankshaft-base/files/opt/crankshaft/crankshaft_default_env.sh \
https://raw.githubusercontent.com/opencardev/crankshaft/crankshaft-ng/stage3/03-crankshaft-base/files/opt/crankshaft/crankshaft_system_env.sh"

SRCREV = "${PV}"

do_install() {
   install -d ${D}/opt/crankshaft
   install -m 0755 ${WORKDIR}/crankshaft_default_env.sh ${D}/opt/crankshaft/
   install -m 0755 ${WORKDIR}/crankshaft_system_env.sh ${D}/opt/crankshaft/
   install -d ${D}/boot/crankshaft
   install -m 0755 ${WORKDIR}/crankshaft_default_env.sh ${D}/boot/crankshaft/crankshaft_env.sh
#   install -d ${D}${systemd_unitdir}/system
#   install -m 0644 ${WORKDIR}/test_systemd.service ${D}${systemd_unitdir}/system
}
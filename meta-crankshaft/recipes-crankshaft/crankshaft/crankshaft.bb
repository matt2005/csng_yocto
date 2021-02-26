DESCRIPTION = "Scripts from crankshaft"
SECTION = "libs"
LICENSE = "crankshaft"
HOMEPAGE = "http://getcrankshaft.com"

DEPENDS = ""

PR = "r0"
LIC_FILES_CHKSUM = "file://README.md;md5=4f71706c758c730491d444715277caa3"
SRC_URI = "git://github.com/opencardev/crankshaft.git;protocol=https;branch=crankshaft-ng; \
           file://0001-Update-to-new-paths-for-yocto-build.patch \
           file://0001-Fix-paths.-Need-to-run-wpa_supplicant-in-order-to-co.patch \
		   https://raw.githubusercontent.com/opencardev/prebuilts/master/udev/51-android.rules;name=androidudev \
           "
SRCREV = "f815963a333e1493986f8cf4c00cb6d67ebc2daa"
SRC_URI[androidudev.md5sum] = "9df760979daf568e33c857ea7a2429ac"
inherit systemd

S = "${WORKDIR}/git"

do_compile_append(){
	cp -f ${S}/../51-android.rules ${S}/51-android.master
	DEST=${S}/51-android.rules
	if [ -f $DEST ]; then
		rm $DEST
	fi
	touch $DEST
	# add master stuff
	echo '' > $DEST
	echo '# Skip storage devices' >> $DEST
	echo 'KERNEL=="sd*", GOTO="SKIP_DEVICE"' >> $DEST
	echo 'KERNEL=="sg*", GOTO="SKIP_DEVICE"' >> $DEST
	echo 'SUBSYSTEM!="usb", GOTO="SKIP_DEVICE"' >> $DEST
	cat ${S}/51-android.master >> $DEST
	# Add action
	sed -i 's/GROUP="plugdev"$/GROUP="plugdev", RUN+="\/opt\/crankshaft\/usb_action.sh add '\'\$env\{ID_MODEL\}\'' '\''%E\{DEVNAME\}'\''"/' $DEST
	# Add disconnect action
	echo '' >> $DEST
	echo '# Disconnect action' >> $DEST
	echo 'SUBSYSTEM=="usb", ACTION=="remove", RUN+="/opt/crankshaft/usb_action.sh remove '\'\$env\{ID_MODEL\}\'' '\''%E{DEVNAME}'\''"' >> $DEST
	# Add disconnect action
	echo '' >> $DEST
	echo '# Skip action' >> $DEST
	echo 'LABEL="SKIP_DEVICE"' >> $DEST
	echo '' >> $DEST
}

do_install() {
	install -d ${D}/opt/crankshaft
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/crankshaft_default_env.sh ${D}/opt/crankshaft/
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/crankshaft_system_env.sh ${D}/opt/crankshaft/
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_hotspot.sh ${D}/opt/crankshaft/
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_hostapdchange.sh ${D}/opt/crankshaft/
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_wpachange.sh ${D}/opt/crankshaft/
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_wifisetup.sh ${D}/opt/crankshaft/
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/usb_action.sh ${D}/opt/crankshaft/

	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/hotspot-monitor.service ${D}${systemd_system_unitdir}
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/wpa-monitor.service ${D}${systemd_system_unitdir}
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/lib/systemd/system/dhcpcd.service ${D}${systemd_system_unitdir}

	#udev rules
	install -d ${D}/etc/udev/rules.d
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/udev/rules.d/10-gpio2kbd.rules ${D}/etc/udev/rules.d/
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/udev/rules.d/51-android.rules ${D}/etc/udev/rules.d/
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/udev/rules.d/51-android.master ${D}/etc/udev/rules.d/
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/udev/rules.d/10-automount.rules ${D}/etc/udev/rules.d/
	install -m 0644 ${S}/51-android.rules ${D}/etc/udev/rules.d/
	
}

FILES_${PN} += "\
	/opt/crankshaft/ \
	${systemd_system_unitdir} \
	/etc/udev/rules.d/ \
"

INSANE_SKIP_${PN} = "file-rdeps"
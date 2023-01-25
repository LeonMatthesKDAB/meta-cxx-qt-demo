inherit qmake5_base systemd

# Adapted from the qmake5 class, as we need to be able to run
# the qmake toolchain.
QTBASEDEPENDS = "qtbase qtbase-native"
QTBASEDEPENDS:class-native = "qtbase-native"
QTBASEDEPENDS:class-nativesdk = "nativesdk-qtbase qtbase-native"
DEPENDS:prepend = "${QTBASEDEPENDS} "
DEPENDS += " qtdeclarative qtquickcontrols2 "

RDEPENDS_${PN} = "qtquickcontrols2 \
		qtgraphicaleffects-qmlplugins \
		ttf-opensans \
		"

export QMAKE="${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/qmake"

# For unknown reasons, the do_package tasks fails without this
# I don't really care about Debug info for the demo, so just disable this
# part of the do_package step
INHIBIT_PACKAGE_DEBUG_SPLIT="1"

LIC_FILES_CHKSUM = " \
    file://LICENSES/MIT.txt;md5=7dda4e90ded66ab88b86f76169f28663 \
"

do_install() {
	cargo_do_install

	mkdir -p ${D}/etc/systemd/system
	mkdir -p ${D}/usr/bin

	cp ${S}/examples/demo_threading/demo.py ${D}/usr/bin
	cp ${S}/examples/demo_threading/demo-threading.service ${S}/examples/demo_threading/demo-threading-sensors.service ${D}/etc/systemd/system
	cp ${S}/examples/demo_threading/demo-threading.env ${D}/etc
}

SYSTEMD_SERVICE:${PN} = "demo-threading.service demo-threading-sensors.service"


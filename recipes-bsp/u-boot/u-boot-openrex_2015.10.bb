# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc

inherit fsl-u-boot-localversion

DESCRIPTION = "U-Boot based on mainline U-Boot used by FSL Community BSP in \
order to provide support for some backpeorted features and fixes, or because it \
was submitted for revision and it takes some time to become part of a stable \
version, or because it is not applicable for upstreaming."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"
COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx6ul|mx7|vf|imx6q-openrex|imx6s-openrex)"

DEPENDS_mxs += "elftosb-native openssl-native"

PROVIDES += "u-boot"

PV = "v2015.10+git${SRCPV}"

SRCBRANCH ??= "jethro"

SRC_URI = "git://github.com/kangdokhui/openrex-uboot-v2015.10.git;branch=${SRCBRANCH}"

#SRCREV is the commit number, must be always changed for a new version
SRCREV = "b7eefa9a5a1d08f8a27103c9c5f2b2876eef6bb9"

S = "${WORKDIR}/git"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"






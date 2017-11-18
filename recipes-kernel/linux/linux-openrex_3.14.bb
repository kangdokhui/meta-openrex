# Copyright (C) 2015, 2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel for OpenRex board"
DESCRIPTION = "Linux Kernel for OpenRex board. More info \
at http://www.imx6rex.com/open-rex"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "jethro"
LOCALVERSION = "-fslc"

#Always update SRCREV based on your last commit
SRCREV = "a357ddb7e7a69035c01b050d7adc593140c7e046"

SRC_URI = "git://github.com/kangdokhui/openrex-linux-3.14.git;branch=${SRCBRANCH} \
           file://defconfig"


#PV .= "+git${SRCPV}"
PV .= "" 


COMPATIBLE_MACHINE = "(mx6|mx7|imx6q-openrex|imx6s-openrex)"

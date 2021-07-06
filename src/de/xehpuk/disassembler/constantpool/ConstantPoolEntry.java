package de.xehpuk.disassembler.constantpool;

import de.xehpuk.disassembler.Dumpable;

/**
 *
 * @author xehpuk
 */
public interface ConstantPoolEntry extends Dumpable {
	ConstantTag getTag();
}

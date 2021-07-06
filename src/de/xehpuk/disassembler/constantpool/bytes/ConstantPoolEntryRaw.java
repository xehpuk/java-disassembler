package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantPoolEntry;

/**
 *
 * @author xehpuk
 */
public interface ConstantPoolEntryRaw extends ConstantPoolEntry {
	ConstantPoolEntry convert(int index, ConstantPool rawPool);
}
package de.xehpuk.disassembler.reader;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantPoolEntry;
import java.io.DataInput;

/**
 *
 * @author xehpuk
 */
public abstract class ReaderNeedingConstantPool<T> extends Reader<T> {
	protected final ConstantPool constantPool;

	protected ReaderNeedingConstantPool(final DataInput in, final ConstantPool constantPool) {
		super(in);
		this.constantPool = constantPool;
	}

	protected ReaderNeedingConstantPool(final ReaderNeedingConstantPool<?> reader) {
		this(reader, reader.constantPool);
	}

	protected <U extends ConstantPoolEntry> U get(final int index, final Class<U> clazz) {
		return constantPool.get(index, clazz);
	}

	protected <U extends ConstantPoolEntry> U get(final int index, final Class<U> clazz, final boolean mayBeZero) {
		return constantPool.get(index, clazz, mayBeZero);
	}
}
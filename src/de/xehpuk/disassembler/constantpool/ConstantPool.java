package de.xehpuk.disassembler.constantpool;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.attribute.BootstrapMethodsTableEntry;
import de.xehpuk.disassembler.constantpool.bytes.ConstantPoolEntryRaw;
import de.xehpuk.disassembler.constantpool.model.ConstantLongNumber;
import de.xehpuk.disassembler.exceptions.IllegalConstantPoolEntryType;
import de.xehpuk.disassembler.util.Util;
import java.util.Arrays;

/**
 *
 * @author xehpuk
 */
public class ConstantPool implements Dumpable {
	private final int size;
	private final ConstantPoolEntryRaw[] rawConstants;
	private final ConstantPoolEntry[] constants;
	private BootstrapMethodsTableEntry[] bootstrapMethodsTable;

	public ConstantPool(final int size) {
		this.size = size;
		this.rawConstants = new ConstantPoolEntryRaw[size];
		this.constants = new ConstantPoolEntry[size];
	}

	public <U extends ConstantPoolEntryRaw> U getRaw(final int index, final Class<U> clazz) {
		try {
			return clazz.cast(rawConstants[index]);
		} catch (final ClassCastException e) {
			throw new IllegalConstantPoolEntryType(index, e);
		}
	}

	public <U extends ConstantPoolEntry> U get(final int index, final Class<U> clazz, final boolean mayBeNull) {
		ConstantPoolEntry constant = constants[index];
		if (!mayBeNull && constant == null) {
			constant = getRaw(index, ConstantPoolEntryRaw.class).convert(index, this);
			set(index, constant);
		}
		try {
			return clazz.cast(constant);
		} catch (final ClassCastException e) {
			throw new IllegalConstantPoolEntryType(index, e);
		}
	}

	public <U extends ConstantPoolEntry> U get(final int index, final Class<U> clazz) {
		return get(index, clazz, false);
	}

	public BootstrapMethodsTableEntry getBootstrapMethods(final int index) {
		return bootstrapMethodsTable[index];
	}

	public void setRaw(final int index, final ConstantPoolEntryRaw rawConstant) {
		Util.requireNull(rawConstants[index]);
		rawConstants[index] = rawConstant;
	}

	private void set(final int index, final ConstantPoolEntry constant) {
		Util.requireNull(constants[index]);
		constants[index] = constant;
	}

	public void set(final BootstrapMethodsTableEntry[] bootstrapMethodsTable) {
		Util.requireNull(bootstrapMethodsTable);
		this.bootstrapMethodsTable = bootstrapMethodsTable;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return "ConstantPool{" + "constants=" + Arrays.toString(constants) + '}';
	}

	@Override
	public void dump(final int indent) {
		if (size > 1) {
			System.out.println();
			int n = 0;
			for (int i = 1; i < size; i++) {
				final ConstantPoolEntry entry = get(i, ConstantPoolEntry.class);
				final String className = Util.constant(entry.getClass().getSimpleName());
				final int nameLength = className.length();
				if (nameLength > n) {
					n = nameLength;
				}
				if (entry instanceof ConstantLongNumber) {
					i++;
				}
			}
			n++;
			for (int i = 1; i < size; i++) {
				final ConstantPoolEntry entry = get(i, ConstantPoolEntry.class);
				final String index = String.format("#%1$0" + Util.digits(size) + "d = ", i);
				final String className = Util.constant(entry.getClass().getSimpleName());
				Util.indent(indent);
				System.out.print(index);
				System.out.printf("%1$-" + n + "s", className);
				entry.dump(0);
				System.out.println();
				if (entry instanceof ConstantLongNumber) {
					i++;
				}
			}
		} else {
			System.out.println("[none]");
		}
		System.out.println();
	}
}
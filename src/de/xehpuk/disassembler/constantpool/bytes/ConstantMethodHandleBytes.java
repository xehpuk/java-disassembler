package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantBootstrapArgumentType;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantFieldref;
import de.xehpuk.disassembler.constantpool.model.ConstantInterfaceMethodref;
import de.xehpuk.disassembler.constantpool.model.ConstantMethodHandle;
import de.xehpuk.disassembler.constantpool.model.ConstantMethodHandle.ByteCodeBehaviors;
import de.xehpuk.disassembler.constantpool.model.ConstantMethodref;

/**
 *
 * @author xehpuk
 */
public class ConstantMethodHandleBytes implements ConstantPoolEntryRaw, ConstantBootstrapArgumentType {
	private final int referenceKind;
	private final int referenceIndex;

	public ConstantMethodHandleBytes(final int referenceKind, final int referenceIndex) {
		this.referenceKind = referenceKind;
		this.referenceIndex = referenceIndex;
	}

	public int getReferenceKind() {
		return referenceKind;
	}

	public int getReferenceIndex() {
		return referenceIndex;
	}

	@Override
	public String toString() {
		return "ConstantMethodHandleInfo{" + "referenceKind=" + referenceKind + ", referenceIndex=" + referenceIndex + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.METHOD_HANDLE;
	}

	@Override
	public ConstantMethodHandle<?> convert(final int index, final ConstantPool pool) {
		final ConstantMethodHandle<?> result;
		final ByteCodeBehaviors referenceKindBehaviour = ByteCodeBehaviors.from(referenceKind);
		switch (referenceKindBehaviour) {
			case GET_FIELD:
			case GET_STATIC:
			case PUT_FIELD:
			case PUT_STATIC: {
				final ConstantFieldref reference = pool.get(referenceIndex, ConstantFieldref.class);
				result = new ConstantMethodHandle<>(referenceKindBehaviour, reference);
				break;
			}
			case INVOKE_VIRTUAL:
			case INVOKE_STATIC:
			case INVOKE_SPECIAL:
			case NEW_INVOKE_SPECIAL: {
				final ConstantMethodref reference = pool.get(referenceIndex, ConstantMethodref.class);
				result = new ConstantMethodHandle<>(referenceKindBehaviour, reference);
				break;
			}
			case INVOKE_INTERFACE: {
				final ConstantInterfaceMethodref reference = pool.get(referenceIndex, ConstantInterfaceMethodref.class);
				result = new ConstantMethodHandle<>(referenceKindBehaviour, reference);
				break;
			}
			default:
				result = null;
		}
		return result;
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
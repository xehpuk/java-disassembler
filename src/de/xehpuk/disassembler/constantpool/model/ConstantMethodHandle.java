package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantPoolEntry;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.exceptions.IllegalReferenceKindException;
import de.xehpuk.disassembler.util.Util;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xehpuk
 */
public class ConstantMethodHandle<T extends ConstantRef> implements ConstantPoolEntry {
	private final ByteCodeBehaviors referenceKind;
	private final T reference;

	public ConstantMethodHandle(final ByteCodeBehaviors referenceKind, final T reference) {
		this.referenceKind = referenceKind;
		this.reference = reference;
	}

	public ByteCodeBehaviors getReferenceKind() {
		return referenceKind;
	}

	public T getReference() {
		return reference;
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.METHOD_HANDLE;
	}

	@Override
	public String toString() {
		return "ConstantMethodHandle{" + "referenceKind=" + referenceKind + ", reference=" + reference + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(getReferenceKind().getDescription() + ' ');
		reference.dump(0);
	}

	public static enum ByteCodeBehaviors {
		GET_FIELD(1, "REF_getField", "getfield C.f:T"),
		GET_STATIC(2, "REF_getStatic", "getstatic C.f:T"),
		PUT_FIELD(3, "REF_putField", "putfield C.f:T"),
		PUT_STATIC(4, "REF_putStatic", "putstatic C.f:T"),
		INVOKE_VIRTUAL(5, "REF_invokeVirtual", "invokevirtual C.m:(A*)T"),
		INVOKE_STATIC(6, "REF_invokeStatic", "invokestatic C.m:(A*)T"),
		INVOKE_SPECIAL(7, "REF_invokeSpecial", "invokespecial C.m:(A*)T"),
		NEW_INVOKE_SPECIAL(8, "REF_newInvokeSpecial", "new C; dup; invokespecial C.<init>:(A*)void"),
		INVOKE_INTERFACE(9, "REF_invokeInterface", "invokeinterface C.m:(A*)T");
		private static final Map<Integer, ByteCodeBehaviors> kindLookup = new HashMap<>(values().length);

		static {
			for (final ByteCodeBehaviors tag : values()) {
				if (kindLookup.put(tag.getKind(), tag) != null) {
					throw new IllegalReferenceKindException(tag.getKind());
				}
			}
		}

		public static ByteCodeBehaviors from(final int kind) {
			final ByteCodeBehaviors result = kindLookup.get(kind);
			if (result == null) {
				throw new IllegalReferenceKindException(kind);
			}
			return result;
		}
		private final int kind;
		private final String description;
		private final String interpretation;

		private ByteCodeBehaviors(final int kind, final String description, final String interpretation) {
			this.kind = kind;
			this.description = description;
			this.interpretation = interpretation;
		}

		public int getKind() {
			return kind;
		}

		public String getDescription() {
			return description;
		}

		public String getInterpretation() {
			return interpretation;
		}
	}
}
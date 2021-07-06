package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DStore3 extends DStoreAbstract {
	protected DStore3() {
		super(3);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DSTORE_3;
	}
}
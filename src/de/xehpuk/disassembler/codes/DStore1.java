package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DStore1 extends DStoreAbstract {
	protected DStore1() {
		super(1);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DSTORE_1;
	}
}
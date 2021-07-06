package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DStore2 extends DStoreAbstract {
	protected DStore2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DSTORE_2;
	}
}
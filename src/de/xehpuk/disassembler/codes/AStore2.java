package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class AStore2 extends AStoreAbstract {
	protected AStore2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ASTORE_2;
	}
}
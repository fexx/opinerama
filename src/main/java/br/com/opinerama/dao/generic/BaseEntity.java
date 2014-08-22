package br.com.opinerama.dao.generic;

import java.io.Serializable;

public interface BaseEntity<PK> extends Serializable {
	public PK getId();
}
package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.WalletDTO;

@Entity
@Table(name="wallet")
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer walletId;
	private Float availableAmount;
	public Integer getWalletId() {
		return walletId;
	}
	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}
	public Float getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(Float availableAmount) {
		this.availableAmount = availableAmount;
	}
	
	public WalletDTO getWalletDTOFromWallet() {
		WalletDTO walletDTO = new WalletDTO();
		walletDTO.setWalletId(this.getWalletId());
		walletDTO.setAvailableAmount(this.getAvailableAmount());
		
		return walletDTO;
	}
	
	public static Wallet getWalletFromWalletDTO(WalletDTO walletDTO) {
		Wallet wallet = new Wallet();
		wallet.setWalletId(walletDTO.getWalletId());
		wallet.setAvailableAmount(walletDTO.getAvailableAmount());
		
		return wallet;
	}
}

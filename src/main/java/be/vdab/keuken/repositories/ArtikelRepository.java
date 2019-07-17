package be.vdab.keuken.repositories;

import java.util.Optional;

import be.vdab.keuken.domain.Artikel;

public interface ArtikelRepository {
	Optional<Artikel> findById(long id);
	void create(Artikel artikel);
}
